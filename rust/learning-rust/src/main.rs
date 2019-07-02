struct Color {
    red: u8,
    green: u8,
    blue: u8,
}

struct Kilometers(i32);

fn main() {
    println!("Hello, world!");

    let x = 2;
    let square = |x: i32| -> i32 {
        x * x
    };
    println!("{}", square(x));

    let black = Color { red: 0, green: 0, blue: 0 };
    println!("Black = rgb({}, {}, {})", black.red, black.green, black.blue);

    let distance = Kilometers(20);
    let Kilometers(distance_in_km) = distance;
    println!("The distance: {} km", distance_in_km);
}
