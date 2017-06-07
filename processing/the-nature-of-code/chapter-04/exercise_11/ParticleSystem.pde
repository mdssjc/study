import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;
  PVector origin;
  PImage img;

  ParticleSystem(PVector location) {
    origin = location.copy();
    particles = new ArrayList<Particle>();
    img = loadImage("data/fire.png");
  }

  void addParticle() {
    particles.add(new Particle(origin, img));
  }

  void applyForce(PVector f) {
    for (Particle p : particles) {
      p.applyForce(f);
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