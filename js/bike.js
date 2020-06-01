var Lab = (function(){    
    "use strict";
    /*                            */
    /* START - Using  prototype   */
    /*                            */

    var Lab1 = (function(){
        var createBicyclePrototye = function(){
            var bicycle = {
                speed: 0,
                applyBrake: function(x){       //decrement the current speed 
                    this.speed = this.speed - x;
                },
                speedup: function(x){          //increment current speed 
                    this.speed = this.speed + x;
                }
            };
            return bicycle;
        };

        var createMountainBikeProtoype   = function(prototype){        
            var bike = Object.create(prototype);
            prototype.gear = 1;
            prototype.setGear = function(x){    //sets gear value 
                this.gear = x;
            };
            return bike;
        };        

        var start = function(){
            var bicyclePrototype  = createBicyclePrototye();
            var mountainBikePrototype = createMountainBikeProtoype(bicyclePrototype);
            test(bicyclePrototype, mountainBikePrototype);
        };

        return {doTest : start};

    }).call(this);
    /*                            */
    /* END - Using  prototype   */
    /*                            */


    /*                            */
    /* START - Using  ES6 class   */
    /*                            */

    var Lab2 = (function(){
        class Bicycle {
            constructor(x){
                this.speed = x;
            }
            applyBrake(x){       //decrement the current speed 
                this.speed = this.speed - x;
            }
            speedup(x){          //increment current speed 
                this.speed = this.speed + x;
            }
        }

        class Bike extends Bicycle{
            constructor(x, bicycle){
                super();
                this.gear = x;
                this.speed = bicycle.speed;
            }
            setGear(x){    //sets gear value 
                this.gear = x;                
            }
        }

        var createBicyclePrototye = function(){
            var bicycle = new Bicycle(0);
            return bicycle;
        };

        var createMountainBikeProtoype   = function(prototype){        
            var bike = new Bike(1,prototype);
            return bike;
        };

        var start = function(){
            var bicyclePrototype  = createBicyclePrototye();
            var mountainBikePrototype = createMountainBikeProtoype(bicyclePrototype);
            test(bicyclePrototype, mountainBikePrototype);
        };

        return {doTest : start};

    }).call(this);

    /*                            */
    /* END - Using  ES6 class     */
    /*                            */

    /*                                        */
    /* START - Using  Constructor functions   */
    /*                                        */

    var Lab3 = (function(){
        var createBicyclePrototye = function(){
            function Bicycle() {
                this.speed = 0;
            }
            Bicycle.prototype.applyBrake = function(x){       //decrement the current speed 
               this.speed = this.speed - x;
            };
            Bicycle.prototype.speedup = function(x){          //increment current speed 
                this.speed = this.speed + x;
            };
            var b = new Bicycle();
            return b;
        };

        var createMountainBikeProtoype   = function(prototype){        
            var bike = Object.create(prototype);
            prototype.gear = 1;
            prototype.setGear = function(x){    //sets gear value 
                this.gear = x;
            };
            return bike;
        };

        var start = function(){
            var bicyclePrototype  = createBicyclePrototye();
            var mountainBikePrototype = createMountainBikeProtoype(bicyclePrototype);
            test(bicyclePrototype, mountainBikePrototype);
        };

        return {doTest : start};

    }).call(this);

    /*                                      */
    /* END - Using  Constructor functions   */
    /*                                      */

    function test(bicycle, bike){
        console.log(bicycle.speed);
        bicycle.speedup(30);
        console.log(bicycle.speed);
        bicycle.applyBrake(10);
        console.log(bicycle.speed);


        console.log(bike.speed);
        bike.speedup(30);
        console.log(bike.speed);
        bike.applyBrake(10);
        console.log(bike.speed);

        console.log(bike.gear);
        bike.setGear(5);
        console.log(bike.gear);
    }

    return {
        run_1 : Lab1.doTest,
        run_2 : Lab2.doTest,
        run_3 : Lab3.doTest
    };

}).call(this);

Lab.run_1();    //using Object.create (prototype)
Lab.run_2();    //using ES6 class construct
Lab.run_3();    //using constructor function











