class Polygon {

  Body body;

  Polygon() {
    BodyDef bd = new BodyDef();
    bd.type = BodyType.DYNAMIC;
    bd.position.set(box2d.coordPixelsToWorld(mouseX, mouseY));
    body = box2d.createBody(bd);

    PolygonShape ps = new PolygonShape();
    Vec2[] vertices = new Vec2[6];  
    vertices[0] = box2d.vectorPixelsToWorld(new Vec2(0, -10));
    vertices[1] = box2d.vectorPixelsToWorld(new Vec2(-5, -5));
    vertices[2] = box2d.vectorPixelsToWorld(new Vec2(-5, 5));
    vertices[3] = box2d.vectorPixelsToWorld(new Vec2(0, 10));
    vertices[4] = box2d.vectorPixelsToWorld(new Vec2(5, 5));
    vertices[5] = box2d.vectorPixelsToWorld(new Vec2(5, -2));
    ps.set(vertices, vertices.length);

    FixtureDef fd = new FixtureDef();
    fd.shape = ps;
    fd.density = 1;
    fd.friction = 0.3;
    fd.restitution = 0.5;

    body.createFixture(fd);
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    Fixture f = body.getFixtureList();
    PolygonShape ps = (PolygonShape) f.getShape();

    rectMode(CENTER);

    pushMatrix();

    translate(pos.x, pos.y);
    rotate(-a);
    fill(50, 255, 100);
    stroke(0);

    beginShape();
    for (int i = 0; i < ps.getVertexCount(); i++) {
      Vec2 v = box2d.vectorWorldToPixels(ps.getVertex(i));
      vertex(v.x, v.y);
    }
    endShape(CLOSE);

    popMatrix();
  }

  void killBody() {
    box2d.destroyBody(body);
  }
}