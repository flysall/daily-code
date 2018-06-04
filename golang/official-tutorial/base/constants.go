package main

import "fmt"

const Pi = 3.14

func main() {
    const World = "World"
    // The const can't be assign again?
    // World = "Boom"
    var word string = "facebook"
    word = "flysall"
    fmt.Println(word)
    fmt.Println("Hello", World)
    fmt.Println("Happy", Pi, "Day")
    fmt.Println(word)

    const Truth = true
    fmt.Println("Go rules?", Truth)
}
