import toxi.physics2d.*;
import toxi.physics2d.behaviors.*;
import toxi.geom.*;

VerletPhysics2D physics;
ArrayList<Cluster> clusters;
boolean showPhysics;
boolean showParticles;
PFont f;

void setup() {
  size(640, 360);
  showPhysics = true;
  showParticles = true;
  f = createFont("Georgia", 12, true);

  physics = new VerletPhysics2D();
  physics.setWorldBounds(new Rect(10, 10, width-20, height-20));
  newGraph();
}

void draw() {
  background(255);

  physics.update();

  if (showParticles) {
    for (Cluster c : clusters) {
      c.display();
    }
  }

  if (showPhysics) {
    for (int i = 0; i < clusters.size(); i++) {
      Cluster ci = clusters.get(i);
      ci.showConnections();
      for (int j = i+1; j < clusters.size(); j++) {
        Cluster cj = clusters.get(j);
        ci.showConnections(cj);
      }
    }
  }

  fill(0);
  textFont(f);
  text("'p' to display or hide particles\n'c' to display or hide connections\n'n' for new graph", 10, 20);
}

void keyPressed() {
  if (key == 'c') {
    showPhysics = !showPhysics;
    if (!showPhysics) {
      showParticles = true;
    }
  } else if (key == 'p') {
    showParticles = !showParticles;
    if (!showParticles) {
      showPhysics = true;
    }
  } else if (key == 'n') {
    newGraph();
  }
}

void newGraph() {
  physics.clear();
  clusters = new ArrayList<Cluster>();

  for (int i = 0; i < 8; i++) {
    Vec2D center = new Vec2D(width/2, height/2);
    clusters.add(new Cluster((int) random(3, 8), random(20, 100), center));
  }

  for (int i = 0; i < clusters.size(); i++) {
    for (int j = i+1; j < clusters.size(); j++) {
      Cluster ci = clusters.get(i);
      Cluster cj = clusters.get(j);
      ci.connect(cj);
    }
  }
}