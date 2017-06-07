import java.util.Iterator;

class ParticleSystem {

  ArrayList<Particle> particles;
  PVector origin;
  ArrayList<PImage> images;

  ParticleSystem(PVector location) {
    origin = location.copy();
    particles = new ArrayList<Particle>();

    images = new ArrayList<PImage>();
    images.add(loadImage("data/corona.png"));
    images.add(loadImage("data/emitter.png"));
    images.add(loadImage("data/particle.png"));
    images.add(loadImage("data/reflection.png"));
    images.add(loadImage("data/texture.png"));
  }

  void addParticle() {
    PImage img = images.get((int) random(images.size()));
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