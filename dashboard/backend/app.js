var express = require('express');
// var path = require('path');
// var cookieParser = require('cookie-parser');
var logger = require('morgan');
// adding the cors
const cors = require('cors');

var indexRouter = require('./routes/index');
var postsRouter = require('./routes/posts');

var app = express();

app.use(cors());
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
// app.use(cookieParser());
// app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
//  fixing the router setting
app.use('/posts', postsRouter);

module.exports = app;
