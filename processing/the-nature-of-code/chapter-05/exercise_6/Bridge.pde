class Bridge {

  ArrayList<Particle> particles;

  Bridge() {
    particles = new ArrayList<Particle>();

    int totalLength = width;
    int numPoints = width/10;
    float len = totalLength / numPoints;

    for (int i = 0; i <= numPoints; i++) {
      particles.add(new Particle(i*len, height/4, 4, (i == 0 || i == numPoints)));
    }

    for (int i = 1; i <= numPoints; i++) {
      DistanceJointDef djd = new DistanceJointDef();
      djd.bodyA = particles.get(i-1).body;
      djd.bodyB = particles.get(i).body;
      djd.length = box2d.scalarPixelsToWorld(len);
      djd.frequencyHz = 0;
      djd.dampingRatio = 0;

      DistanceJoint dj = (DistanceJoint) box2d.world.createJoint(djd);
    }
  }

  void display() {
    for (Particle p : particles) {
      p.display();
    }
  }
}