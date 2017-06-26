class Spring {

  Body body;

  void bind(Box box) {
    body = box.body;
  }

  void update() {
    Vec2 pos = body.getWorldCenter();
    Vec2 target = box2d.coordPixelsToWorld(mouseX, mouseY);
    Vec2 v = target.sub(pos);

    body.setLinearVelocity(v);
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);

    stroke(0);
    strokeWeight(1);
    line(pos.x, pos.y, mouseX, mouseY);
  }
}