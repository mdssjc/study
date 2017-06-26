class Mover {

  Body body;
  float mass;
  ArrayList<PVector> trail;
  int limit;

  Mover(float m, float x, float y) {
    mass = m;

    trail = new ArrayList();
    limit = 200;

    makeBody(new Vec2(x, y), m);
  }

  void applyForce(Vec2 force) {
    Vec2 pos = body.getWorldCenter();
    body.applyForce(force, pos);
  }

  void update() {
    if (trail.size() > limit) {
      trail.remove(0);
    }
    Vec2 pos = box2d.getBodyPixelCoord(body);
    trail.add(new PVector(pos.x, pos.y));
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    pushMatrix();

    translate(pos.x, pos.y);
    rotate(-a);

    stroke(0);
    strokeWeight(2);
    fill(127, 200);

    ellipse(0, 0, mass*16, mass*16);
    line(0, 0, mass*8, 0);

    popMatrix();

    noStroke();
    fill(127, 10);

    for (int i = 0; i < trail.size(); i++) {
      ellipse(trail.get(i).x, trail.get(i).y, mass*16, mass*16);
    }
  }

  void makeBody(Vec2 center, float m) {
    BodyDef bd = new BodyDef();
    bd.type = BodyType.DYNAMIC;
    bd.position = box2d.coordPixelsToWorld(center);
    body = box2d.createBody(bd);

    CircleShape cs = new CircleShape();
    cs.m_radius = box2d.scalarPixelsToWorld(m);

    FixtureDef fd = new FixtureDef();
    fd.shape = cs;
    fd.density = 1;
    fd.friction = 0.3;
    fd.restitution = 0.1;

    body.createFixture(fd);

    body.setLinearVelocity(new Vec2(random(-5, 5), random(-5, -5)));
    body.setAngularVelocity(random(-1, 1));
  }
}