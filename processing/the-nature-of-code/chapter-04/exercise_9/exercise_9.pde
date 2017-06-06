import java.util.Iterator;

ParticleSystem ps;
ArrayList<Repeller> repellers;

void setup() {
  size(640, 360);

  ps = new ParticleSystem(new PVector(width/2, 50));

  repellers = new ArrayList<Repeller>();
  for (int i = 0; i < 3; i++) {
    repellers.add(new Repeller(random(width*.3, width*.7), height/2));
  }
}

void draw() {
  background(255);

  ps.addParticle();

  PVector gravity = new PVector(0, 0.1);
  ps.applyForce(gravity);

  Iterator<Repeller> it = repellers.iterator();
  while (it.hasNext()) {
    Repeller repeller = it.next();
    ps.applyRepeller(repeller);
    repeller.display();
  }

  ps.run();
}