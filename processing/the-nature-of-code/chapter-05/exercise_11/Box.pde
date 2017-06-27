class Box implements Collision {

  Body body;
  float w;
  float h;

  Box(float x_, float y_) {
    float x = x_;
    float y = y_;
    w = 24;
    h = 24;

    makeBody(new Vec2(x, y), w, h);
    body.setUserData(this);
  }

  void killBody() {
    box2d.destroyBody(body);
  }

  void change() {
    if (random(1) < 0.1) {
      w = random(4, 24);
    } else {
      h = random(4, 24);
    }
  }

  boolean done() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    if (pos.y > height+h) {
      killBody();
      return true;
    }
    return false;
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    rectMode(PConstants.CENTER);
    pushMatrix();

    translate(pos.x, pos.y);
    rotate(a);

    fill(127);
    stroke(0);
    strokeWeight(2);

    rect(0, 0, w, h);

    popMatrix();
  }

  void makeBody(Vec2 center, float w_, float h_) {
    BodyDef bd = new BodyDef();
    bd.type = BodyType.DYNAMIC;
    bd.position.set(box2d.coordPixelsToWorld(center));
    body = box2d.createBody(bd);

    PolygonShape sd = new PolygonShape();
    float box2dW = box2d.scalarPixelsToWorld(w_/2);
    float box2dH = box2d.scalarPixelsToWorld(h_/2);
    sd.setAsBox(box2dW, box2dH);

    FixtureDef fd = new FixtureDef();
    fd.shape = sd;
    fd.density = 1;
    fd.friction = 0.3;
    fd.restitution = 0.5;

    body.createFixture(fd);
    body.setAngularVelocity(random(-5, 5));
  }
}