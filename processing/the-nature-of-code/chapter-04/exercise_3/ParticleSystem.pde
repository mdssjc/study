import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;
  PVector origin;

  ParticleSystem(PVector location) {
    origin = location.copy();
    particles = new ArrayList();
  }

  void addParticle() {
    Particle p = new Particle(new PVector(mouseX, mouseY));
    p.applyForce(new PVector(random(-2, 2), 2));
    particles.add(p);
  }

  void run() {
    Iterator<Particle> it = particles.iterator();

    while (it.hasNext()) {
      Particle p = it.next();
      p.run();
      if (p.isDead()) {
        it.remove();
      }
    }
  }
}