class Surface {

  ArrayList<Vec2> surface;

  Surface() {
    surface = new ArrayList<Vec2>();
    ChainShape chain = new ChainShape();
    Vec2[] vertices = new Vec2[width/10+1];

    float period = vertices.length;
    float amplitude = 100;
    // float ty = 20;

    for (int i = 0; i < vertices.length; i++) {
      float y = amplitude * cos(2 * TWO_PI * i / period) + 200;
      // float y = map(noise(ty), 0, 1, 0, height);

      surface.add(new Vec2(i*10, y));
      vertices[i] = box2d.coordPixelsToWorld(surface.get(i));

      // ty += 0.01;
    }

    chain.createChain(vertices, vertices.length);

    BodyDef bd = new BodyDef();
    Body body = box2d.world.createBody(bd);
    body.createFixture(chain, 1);
  }

  void display() {
    strokeWeight(1);
    stroke(0);
    noFill();

    beginShape();
    for (Vec2 v : surface) {
      vertex(v.x, v.y);
    }
    endShape();
  }
}