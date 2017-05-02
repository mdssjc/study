class Oscillator {

  PVector angle;
  PVector velocity;
  PVector amplitude;

  Oscillator(float vx, float vy, float ax, float ay) {
    angle = new PVector();
    velocity = new PVector(vx, vy);
    amplitude = new PVector(ax, ay);
  }

  void oscillate() {
    angle.add(velocity);
  }

  void display() {
    float x = sin(angle.x) * amplitude.x;
    float y = sin(angle.y) * amplitude.y;

    pushMatrix();

    translate(width/2, height/2);
    stroke(0);
    fill(175);
    line(0, 0, x, y);
    ellipse(x, y, 16, 16);

    popMatrix();
  }
}