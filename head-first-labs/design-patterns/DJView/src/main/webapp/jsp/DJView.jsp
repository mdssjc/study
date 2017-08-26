<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
  <head>
    <title>DJ View</title>
  </head>

  <body>
    <h1>DJ View</h1>
    Beats per minutes = ${beatModel.BPM == 0 or empty beatModel.BPM ? 'offline' : beatModel.BPM}
    <br />
    <hr>
    <br />
    <form method="post" action="djview">
      BPM: <input type=text name="bpm" value="${beatModel.BPM == 0 or empty beatModel.BPM ? 0 : beatModel.BPM}">
      &nbsp;
      <input type="submit" name="set" value="set"><br />
      <input type="submit" name="decrease" value="<<">
      <input type="submit" name="increase" value=">>"><br />
      <input type="submit" name="on" value="on">
      <input type="submit" name="off" value="off"><br />
    </form>
  </body>
</html>
