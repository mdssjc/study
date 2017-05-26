import java.util.Iterator;

class ParticleSystem {

  PVector origin;
  ArrayList<Particle> particles;
  int count;

  ParticleSystem(PVector o) {
    origin = o;
    particles = new ArrayList();
    count = 0;
  }

  void addParticle() {
    Particle p = new Particle(origin);
    p.applyForce(new PVector(random(-2, 2), 2));

    if (count <= 100) {
      particles.add(p);
      count++;
    }
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

  boolean isEmpty() {
    return particles.isEmpty();
  }
}