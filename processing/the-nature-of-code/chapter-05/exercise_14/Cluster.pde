class Cluster {

  ArrayList<Node> nodes;
  float diameter;

  Cluster(int n, float d, Vec2D center) {
    nodes = new ArrayList<Node>();
    diameter = d;

    for (int i = 0; i < n; i++) {
      nodes.add(new Node(center.add(Vec2D.randomVector())));
    }

    for (int i = 0; i < nodes.size()-1; i++) {
      VerletParticle2D ni = nodes.get(i);
      for (int j = i+1; j < nodes.size(); j++) {
        VerletParticle2D nj = nodes.get(j);
        physics.addSpring(new VerletSpring2D(ni, nj, diameter, 0.05));
      }
    }
  }

  void display() {
    for (Node n : nodes) {
      n.display();
    }
  }

  void showConnections() {
    stroke(0, 150);
    strokeWeight(2);
    for (int i = 0; i < nodes.size()-1; i++) {
      VerletParticle2D pi = nodes.get(i);
      for (int j = i+1; j < nodes.size(); j++) {
        VerletParticle2D pj = nodes.get(j);
        line(pi.x, pi.y, pj.x, pj.y);
      }
    }
  }

  void move(int x, int y) {
    VerletParticle2D pi = nodes.get(0);
    pi.lock();
    pi.setX(x);
    pi.setY(y);
    pi.unlock();
  }
}