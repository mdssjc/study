class Crazy extends Particle {

  int theta;

  Crazy(PVector l) {
    super(l);
  }

  void display() {
    theta += 5;
    
    rectMode(CENTER);
    stroke(0, lifespan);
    fill(0, lifespan);

    pushMatrix();
    translate(location.x + random(30), location.y);
    rotate(radians(theta));

    ellipse(0, 0, 10, 12);
    rect(0, 5, 5, 13);

    popMatrix();
  }
}