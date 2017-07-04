import toxi.physics2d.*;
import toxi.physics2d.behaviors.*;
import toxi.geom.*;

VerletPhysics2D physics;
Cluster cluster;
boolean showPhysics;
boolean showParticles;
PFont f;

void setup() {
  size(640, 360);
  showPhysics = true;
  showParticles = true;
  f = createFont("Georgia", 12, true);

  physics = new VerletPhysics2D();
  physics.addBehavior(new GravityBehavior2D(new Vec2D(0, 0.5)));
  physics.setWorldBounds(new Rect(0, 0, width, height));
  cluster = new Cluster(8, 100, new Vec2D(width/2, height/2));
}

void draw() {
  background(255);
  physics.update();

  if (showParticles) {
    cluster.display();
  }

  if (showPhysics) {
    cluster.showConnections();
  }

  fill(0);
  textFont(f);
  text("'p' to display or hide particles\n'c' to display or hide connections\n'n' for new graph", 10, 20);
}

void mouseDragged() {
  cluster.move(mouseX, mouseY);
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
    physics.clear();
    cluster = new Cluster(int(random(2, 20)), random(10, width/2), new Vec2D(width/2, height/2));
  }
}