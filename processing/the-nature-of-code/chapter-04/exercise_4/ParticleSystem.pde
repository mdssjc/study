import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;

  ParticleSystem() {
    particles = new ArrayList();
  }

  void addParticle(float x, float y, PVector force) {
    particles.add(new Particle(new PVector(x, y), force));
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