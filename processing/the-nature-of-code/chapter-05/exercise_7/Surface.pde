class Surface {

  ArrayList<Vec2> surface;

  Surface() {
    surface = new ArrayList<Vec2>();

    float theta = 0;
    for (float x = width+10; x > -10; x -= 5) {
      float y = map(cos(theta), -1, 1, height-40, height-10);
      theta += 0.15;
      surface.add(new Vec2(x, y));
    }

    Vec2[] vertices = new Vec2[surface.size()];
    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = box2d.coordPixelsToWorld(surface.get(i));
    }

    ChainShape chain = new ChainShape();
    chain.createChain(vertices, vertices.length);

    BodyDef bd = new BodyDef();
    Body body = box2d.world.createBody(bd);
    body.createFixture(chain, 1);
  }

  void display() {
    noFill();
    strokeWeight(2);
    stroke(0);

    beginShape();
    for (Vec2 v : surface) {
      vertex(v.x, v.y);
    }
    endShape();
  }
}