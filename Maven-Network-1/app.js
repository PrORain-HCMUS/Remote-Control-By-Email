const express = require('express');
const bodyParser = require('body-parser');
const { Sequelize, DataTypes } = require('sequelize');

const app = express();
const port = 3000;

// Kết nối tới SQLite database
const sequelize = new Sequelize({
    dialect: 'sqlite',
    storage: 'database.sqlite',
    logging: false,
});

// Định nghĩa mô hình User
const User = sequelize.define('User', {
    username: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true,
    },
    email: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true,
    },
    password: {
        type: DataTypes.STRING,
        allowNull: false,
    },
});

// Tạo bảng trong database
async function createTables() {
    try {
        await sequelize.sync();
        console.log('Database and tables created!');
        return null;
    } catch (error) {
        console.error(error);
        throw error;
    }
}

// Middleware để xử lý dữ liệu POST
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Đường dẫn đăng ký tài khoản
app.post('/register', async (req, res) => {
    try {
        const { username, email, password } = req.body;

        // Tạo một bản ghi mới trong bảng User
        const user = await User.create({
            username,
            email,
            password,
        });

        res.status(201).json({ message: 'User registered successfully', user });
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Đường dẫn đăng nhập tài khoản
app.post('/login', async (req, res) => {
    try {
        const { username, password } = req.body;

        // Tìm user trong database
        const user = await User.findOne({
            where: {
                username,
                password,
            },
        });

        if (user) {
            res.json({ message: 'Login successful', user });
        } else {
            res.status(401).json({ error: 'Invalid credentials' });
        }
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
})

// Tạo bảng và lắng nghe cổng
createTables()
    .then(() => {
        app.listen(port, () => {
            console.log(`Server is running at http://localhost:${port}`);
        });
    })
    .catch((error) => {
        console.error('Failed to start the server:', error);
    });
