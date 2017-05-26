import java.util.Iterator;

ArrayList<ParticleSystem> systems;

void setup() {
  size(600, 200);
  systems = new ArrayList<ParticleSystem>();
}

void draw() {
  background(255);
  Iterator<ParticleSystem> it = systems.iterator();

  while (it.hasNext()) {
    ParticleSystem ps = it.next();
    ps.run();
    ps.addParticle();
    if (ps.isEmpty()) {
      it.remove();
    }
  }
}

void mousePressed() {
  systems.add(new ParticleSystem(new PVector(mouseX, mouseY)));
}