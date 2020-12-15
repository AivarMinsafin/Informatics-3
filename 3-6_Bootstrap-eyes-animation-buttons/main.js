function skyblue(){
    if (document.getElementById("cont-back").classList.contains('background-lightskyblue')){
        document.getElementById("cont-back").classList.remove('background-lightskyblue');
    }
    if (document.getElementById("cont-back").classList.contains('background-lightcoral')){
        document.getElementById("cont-back").classList.remove('background-lightcoral');
    }
    if (document.getElementById("cont-back").classList.contains('background-lightgreen')){
        document.getElementById("cont-back").classList.remove('background-lightgreen');
    }
    document.getElementById("cont-back").classList.add('background-lightskyblue');
}

function coral(){
    if (document.getElementById("cont-back").classList.contains('background-lightskyblue')){
        document.getElementById("cont-back").classList.remove('background-lightskyblue');
    }
    if (document.getElementById("cont-back").classList.contains('background-lightcoral')){
        document.getElementById("cont-back").classList.remove('background-lightcoral');
    }
    if (document.getElementById("cont-back").classList.contains('background-lightgreen')){
        document.getElementById("cont-back").classList.remove('background-lightgreen');
    }
    document.getElementById("cont-back").classList.add('background-lightcoral');
}

function green(){
    if (document.getElementById("cont-back").classList.contains('background-lightskyblue')){
        document.getElementById("cont-back").classList.remove('background-lightskyblue');
    }
    if (document.getElementById("cont-back").classList.contains('background-lightcoral')){
        document.getElementById("cont-back").classList.remove('background-lightcoral');
    }
    if (document.getElementById("cont-back").classList.contains('background-lightgreen')){
        document.getElementById("cont-back").classList.remove('background-lightgreen');
    }
    document.getElementById("cont-back").classList.add('background-lightgreen');
}

let list = ['lightskyblue', 'lightcoral', 'lightgreen'];


function change(){
    let temp = list[2];
    list[2] = list[1];
    list[1] = list[0];
    list[0] = temp;
    document.getElementById("sky").className = "btn";
    document.getElementById("coral").className = "btn";
    document.getElementById("green").className = "btn";
    document.getElementById("sky").className += " background-"+list[0];
    document.getElementById("coral").className += " background-"+list[1];
    document.getElementById("green").className += " background-"+list[2];
}

document.getElementById("sky").onclick = skyblue;
document.getElementById("coral").onclick = coral;
document.getElementById("green").onclick = green;
document.getElementById("change").onclick = change;