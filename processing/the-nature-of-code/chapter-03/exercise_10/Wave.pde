class Wave {

  PVector origin;
  float amplitude;
  float period;
  float startAngle;
  float angleVel;

  Wave(PVector o, float a, float p) {
    origin = o.copy();
    amplitude = a;
    period = p;
    startAngle = 0.0;
    angleVel = 0.1;
  }

  void display() {
    startAngle += 0.05;
    float angle = startAngle;

    for (int x = 0; x <= period; x += 10) {
      float y = map(sin(angle), -1, 1, 0, amplitude);

      stroke(0);
      fill(0, 50);
      ellipse(origin.x + x, origin.y + y, 48, 48);

      angle += angleVel;
    }
  }
}