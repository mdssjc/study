class Polygon {

  Body body;

  Polygon() {
    BodyDef bd = new BodyDef();
    bd.type = BodyType.DYNAMIC;
    bd.position.set(box2d.coordPixelsToWorld(mouseX, mouseY));
    body = box2d.createBody(bd);

    PolygonShape ps = new PolygonShape();
    Vec2[] vertices = new Vec2[6];
    vertices[0] = box2d.vectorPixelsToWorld(new Vec2(0, 0));
    vertices[1] = box2d.vectorPixelsToWorld(new Vec2(-5, -10));
    vertices[2] = box2d.vectorPixelsToWorld(new Vec2(-10, -10));
    vertices[3] = box2d.vectorPixelsToWorld(new Vec2(-10, 10));
    vertices[4] = box2d.vectorPixelsToWorld(new Vec2(-5, 10));
    vertices[5] = box2d.vectorPixelsToWorld(new Vec2(-5, 0));
    ps.set(vertices, vertices.length);
    body.createFixture(ps, 1.0);

    ps = new PolygonShape();
    vertices = new Vec2[6];
    vertices[0] = box2d.vectorPixelsToWorld(new Vec2(0, 0));
    vertices[1] = box2d.vectorPixelsToWorld(new Vec2(5, 10));
    vertices[2] = box2d.vectorPixelsToWorld(new Vec2(10, 10));
    vertices[3] = box2d.vectorPixelsToWorld(new Vec2(10, -10));
    vertices[4] = box2d.vectorPixelsToWorld(new Vec2(5, -10));
    vertices[5] = box2d.vectorPixelsToWorld(new Vec2(5, 0));
    ps.set(vertices, vertices.length);
    body.createFixture(ps, 1.0);
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    rectMode(CENTER);

    pushMatrix();

    translate(pos.x, pos.y);
    rotate(-a);
    fill(50, 255, 100);
    stroke(0);

    beginShape();
    vertex(0, 0);
    vertex(-5, -10);
    vertex(-10, -10);
    vertex(-10, 10);
    vertex(-5, 10);
    vertex(-5, 3);
    vertex(0, 7);
    vertex(5, 3);
    vertex(5, 10);
    vertex(10, 10);
    vertex(10, -10);
    vertex(5, -10);
    endShape(CLOSE);

    popMatrix();
  }

  void killBody() {
    box2d.destroyBody(body);
  }
}