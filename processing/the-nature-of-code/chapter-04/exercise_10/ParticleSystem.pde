import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;
  PVector origin;

  ParticleSystem(PVector location) {
    origin = location.copy();
    particles = new ArrayList<Particle>();
  }

  void addParticle() {
    particles.add(new Particle(origin));
  }

  void applyForce(PVector f) {
    for (Particle p : particles) {
      p.applyForce(f);
    }
  }

  void applyRepeller(Repeller r) {
    for (Particle p : particles) {
      PVector force = r.repel(p);
      p.applyForce(force);
    }
  }

  void applyRepellerOthers(Repeller r, ArrayList<Particle> o) {
    for (Particle p : o) {
      PVector force = r.repel(p);
      p.applyForce(force);
    }
  }

  void run() {
    Iterator<Particle> it = particles.iterator();
    while (it.hasNext()) {
      Particle p = it.next();

      ArrayList<Particle> others = new ArrayList<Particle>();
      others.addAll(0, particles);
      others.remove(p);
      Repeller r = new Repeller(p.location.x, p.location.y);
      applyRepellerOthers(r, others);

      p.run();
      if (p.isDead()) {
        it.remove();
      }
    }
  }
}