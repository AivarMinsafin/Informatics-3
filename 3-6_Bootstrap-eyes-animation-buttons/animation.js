let element = document.getElementById("element");
let parent = document.getElementById("frame");

let height = window.getComputedStyle(element).height;
height = parseInt(height.substr(0, height.length - 2));
console.log(height);

let width = window.getComputedStyle(element).width;
width = parseInt(width.substr(0, width.length - 2));
console.log(width);

let heightFrame = window.getComputedStyle(parent).height;
heightFrame = parseInt(heightFrame.substr(0, heightFrame.length - 2));
console.log(heightFrame);

let widthFrame = window.getComputedStyle(parent).width;
widthFrame = parseInt(widthFrame.substr(0, widthFrame.length - 2));
console.log(widthFrame);

element.onclick = animation;

function animation() {
    let start = Date.now();
    let posx = 0;
    let posy = 0;
    let right = true;
    let down = true;

    let it = setInterval(frame, 8);

    function frame() {
        let time = Date.now() - start;
        if (time > 15000) {
            clearInterval(it);
        }
        if (posx > widthFrame - width){
            right = false
        }
        if (posx == 0){
            right = true;
        }
        if (posy > heightFrame - height){
            down = false;
        }
        if (posy == 0){
            down = true;
        }
        if (right){
            if (down){
                posx++;
                posy++;
            }else {
                posx++;
                posy--;
            }
        } else {
            if (down){
                posx--;
                posy++;
            }else {
                posx--;
                posy--;
            }
        }
        draw(posx, posy);
    }
}

function draw(posx, posy) {
    console.log(posx, posy);
    element.style.left = posx + "px";
    element.style.top = posy + "px";
}

function goLeftUp(posx, posy) {
    console.log(posx, posy);
    element.style.left = posx + "px";
    element.style.top = posy + "px";
}

function goRightDown(posx, posy) {
    console.log(posx, posy);
    element.style.left = posx + "px";
    element.style.top = posy + "px";
}

function goRightUp(posx, posy) {
    console.log(posx, posy);
    element.style.left = posx + "px";
    element.style.top = posy + "px";
}