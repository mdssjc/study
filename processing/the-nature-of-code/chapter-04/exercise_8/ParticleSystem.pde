import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;
  PVector origin;

  ParticleSystem(PVector location) {
    origin = location.copy();
    particles = new ArrayList<Particle>();
  }

  void addParticle() {
    float r = random(1);

    if (r < 0.4) {
      particles.add(new Particle(origin));
    } else if (r < 0.7) {
      particles.add(new Confetti(origin));
    } else {
      particles.add(new Crazy(origin));
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
}