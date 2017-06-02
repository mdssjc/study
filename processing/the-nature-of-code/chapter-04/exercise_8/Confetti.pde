class Confetti extends Particle {

  Confetti(PVector l) {
    super(l);
  }

  void display() {
    float theta = atan2(location.y, location.x);

    rectMode(CENTER);
    stroke(0, lifespan);
    fill(0, lifespan);

    pushMatrix();
    translate(location.x, location.y);
    rotate(theta);

    rect(0, 0, 8, 8);

    popMatrix();
  }
}