Wave waves[];

void setup() {
  size(750, 200);

  waves = new Wave[5];

  float period = 0;
  float x = 0;
  for (int i = 0; i < waves.length; i++) {
    float amplitude = random(10, 30);
    if (i > 0) {
      x += period;
    }
    period = random(100, 300);
    waves[i] = new Wave(new PVector(x, height/2), amplitude, period);
  }
}

void draw() {
  background(255);

  for (int i = 0; i < waves.length; i++) {
    waves[i].display();
  }
}