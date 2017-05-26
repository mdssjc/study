import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;

  int rows = 20;
  int cols = 20;
  boolean intact;

  ParticleSystem(PVector o) {
    particles = new ArrayList();
    intact = true;

    for (int i = 0; i < rows * cols; i++) {
      addParticle(new PVector(
        o.x + (i % cols) * 10, 
        o.y + (i / rows) * 10));
    }
  }

  void addParticle(PVector o) {
    particles.add(new Particle(o));
  }

  void run() {
    Iterator<Particle> it = particles.iterator();

    while (it.hasNext()) {
      Particle p = it.next();
      if (!intact) {
        p.run();
        if (p.isDead()) {
          it.remove();
        }
      } else {
        p.display();
      }
    }
  }

  void shatter() {
    intact = false;
  }
}