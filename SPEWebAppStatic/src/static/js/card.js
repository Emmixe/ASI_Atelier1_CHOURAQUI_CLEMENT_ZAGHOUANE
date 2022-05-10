function generate(){

    const GET_URL="https://asi2-backend-market.herokuapp.com/cards"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_URL,context)
        .then(response => response.json())
            .then(response => callback(response))
            .catch(error => err_callback(error));
}

function callback(response){
    // console.log(response[41]);
    create_card_object(response, 1); //second parameter is the id of the desired card
    create_card_object(response, 2); //second parameter is the id of the desired card

    console.log(cardlist);
    

}

function err_callback(error){
    console.log(error);
}



let cardlist = [
         {
             family_src:"https://imgc.allpostersimages.com/img/print/affiches/marvel-super-hero-squad-iron-man-standing_a-G-9448041-4985690.jpg",
             family_name:"Jose",
             image_src:"https://imgc.allpostersimages.com/img/print/affiches/marvel-super-hero-squad-iron-man-standing_a-G-9448041-4985690.jpg",
             date:"14h",
             comment:"3 comments",
             like: "17 likes",
             button: "Buy"
         },
         {
             family_src:"https://media.giphy.com/media/l4q8hciiYNT5RGi4w/giphy.gif",
             family_name:"John",
             image_src:"https://media.giphy.com/media/l4q8hciiYNT5RGi4w/giphy.gif",
             date:"1h",
             comment:"345 comments",
             like: "1000 likes",
             button: "Read"
         },
         {
             family_src:"http://www.superherobroadband.com/app/themes/superhero/assets/img/superhero.gif",
             family_name:"Elliot",
             image_src:"http://www.superherobroadband.com/app/themes/superhero/assets/img/superhero.gif",
             date:"142h",
             comment:"0 comment",
             like: "1 likes",
             button: "Read"
        },

    ];


function create_card_object(response, id){
    var card = new Object();
    card.family_src = "";
    card.family_name = response[id].family
    card.name = response[id].name;
    card.description = response[id].description;
    card.imgUrl = response[id].imgUrl; //"https://media.giphy.com/media/6nWT5GyxsmAoM/giphy.gif"
    card.HP = response[id].hp
    card.energy = response[id].energy
    card.attack = response[id].attack
    card.defence = response[id].defence

    // card.date = "12h";
    // card.comment = "0 comment";
    // card.like = "2 likes";
    // card.button = "Read";
    cardlist.push(card);
    display(card);
}


let template = document.querySelector("#selectedCard");

for(const card of cardlist){
    display(card);
}

function display(card){
    let clone = document.importNode(template.content, true);
    newContent= clone.firstElementChild.innerHTML
                .replace(/{{family_src}}/g, card.family_src)
                .replace(/{{image_src}}/g, card.imgUrl)
                .replace(/{{family_name}}/g, card.family_name)
                .replace(/{{name}}/g, card.name)
                .replace(/{{description}}/g, card.description)
                .replace(/{{HP}}/g, card.HP)
                .replace(/{{energy}}/g, card.energy)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defence}}/g, card.defence)

                // .replace(/{{image_src}}/g, card.image_src)
                // .replace(/{{date}}/g, card.date)
                // .replace(/{{comment}}/g, card.comment)
                // .replace(/{{like}}/g, card.like)
                // .replace(/{{button}}/g, card.button);
    clone.firstElementChild.innerHTML= newContent;

    let cardContainer= document.querySelector("#gridContainer");
    cardContainer.appendChild(clone);
}

generate()

