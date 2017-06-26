class Attractor {

  Body body;
  float mass;
  float G;
  boolean visible;

  Attractor(float m, float x, float y, boolean v) {
    mass = m;
    G = m / 2;
    visible = v;

    makeBody(new Vec2(x, y), m);
  }

  Vec2 attract(Mover m) {
    Vec2 pos = body.getWorldCenter();
    Vec2 moverPos = m.body.getWorldCenter();
    Vec2 force = pos.sub(moverPos);
    float distance = force.length();
    distance = constrain(distance, 1, 5);
    force.normalize();

    float strength = (G * mass * m.body.m_mass) / (distance * distance);
    force.mulLocal(strength);
    return force;
  }

  void display() {  
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    pushMatrix();

    translate(pos.x, pos.y);
    rotate(-a);

    if (visible) {
      stroke(0);
      fill(175, 200);
    } else {
      stroke(0, 10);
      noFill();
    }

    ellipse(0, 0, mass*2, mass*2);

    popMatrix();
  }

  void makeBody(Vec2 center, float m) {
    BodyDef bd = new BodyDef();
    bd.type = BodyType.STATIC;
    bd.position = box2d.coordPixelsToWorld(center);
    body = box2d.world.createBody(bd);

    CircleShape cs = new CircleShape();
    cs.m_radius = box2d.scalarPixelsToWorld(m);

    body.createFixture(cs, 1);
  }
}