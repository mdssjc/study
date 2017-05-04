class Wave {

  PVector origin;
  float amplitude;
  float period;
  float startAngle;
  float angleVel;
  int xspacing;

  Wave(PVector o, float a, float p) {
    origin = o.copy();
    amplitude = a;
    period = p;
    startAngle = 0.0;
    angleVel = 0.1;
    xspacing = 8;
  }

  void display() {
    startAngle += 0.02;
    float angle = startAngle;

    for (int x = 0; x <= period; x+= xspacing) {
      float y =+ sin(angle) * amplitude;

      stroke(0);
      fill(0, 50);
      ellipse(origin.x + x, origin.y + y, 48, 48);

      angle += (TWO_PI / period) * xspacing;
    }
  }
}