<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <jsp:useBean id="miBean" class="beans.Grados" scope="request" />
    <jsp:setProperty name="miBean" property="temperatura" value="20 grados" />
    <h1>Obtenido Temperatura</h1>
    <hr />
    <h2><jsp:getProperty name="miBean" property="temperatura" /></h2>
  </body>
</html>
