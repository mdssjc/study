class Box {

  Body body;
  float w;
  float h;

  Box(float x, float y, float _w, float _h, boolean fixed) {
    w = _w;
    h = _h;

    BodyDef bd = new BodyDef();
    bd.position = box2d.coordPixelsToWorld(x, y);
    if (fixed) {
      bd.type = BodyType.STATIC;
    } else {
      bd.type = BodyType.DYNAMIC;
    }
    body = box2d.world.createBody(bd);

    PolygonShape ps = new PolygonShape();
    float box2dW = box2d.scalarPixelsToWorld(w/2);
    float box2dH = box2d.scalarPixelsToWorld(h/2);
    ps.setAsBox(box2dW, box2dH);

    FixtureDef fd = new FixtureDef();
    fd.shape = ps;
    fd.density = 1;
    fd.friction = 0.1;
    fd.restitution = 0.5;

    body.createFixture(fd);

    body.setLinearVelocity(new Vec2(0, 0));
    body.setAngularVelocity(0);
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    rectMode(PConstants.CENTER);
    pushMatrix();

    translate(pos.x, pos.y);
    rotate(-a);

    fill(80);
    stroke(0);
    strokeWeight(1);
    rect(0, 0, w, h);

    popMatrix();
  }

  void killBody() {
    box2d.destroyBody(body);
  }
}