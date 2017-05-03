Wave wave[];

void setup() {
  size(400, 200);

  wave = new Wave[2];
  wave[0] = new Wave(new PVector(150, 30), 100, 100);
  wave[1] = new Wave(new PVector(50, 50), 50, 50);
}

void draw() {
  background(255);

  for (int i = 0; i < wave.length; i++) {
    wave[i].display();
  }
}