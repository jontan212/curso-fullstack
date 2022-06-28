<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
  </head>
  <body>
    <h1>Campo</h1>
    <jsp:useBean id="miBean" class="beans.Campo" scope="request" />
    <jsp:setProperty name="miBean" property="codigo" param="codigo" />
    <img src='/equipos/images/<jsp:getProperty name="miBean" property="campoURL" />' alt="s" />
  </body>
</html>
