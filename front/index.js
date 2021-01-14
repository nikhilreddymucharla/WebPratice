var http = require('http');

http.createServer(function (req, res) {
  res.write(`
	<!doctype html>
	<html lang="en">
	<head>
	  <meta charset="utf-8">
	
	  <title>Hello Buddy!</title>
	  <meta name="description" content="Hello Buddy!">
	</head>
	
	<body>
		<div>
			Hello Buddy!
		</div>
	</body>
	</html>
  `);
  res.end();
}).listen(80);