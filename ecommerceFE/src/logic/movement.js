export default function movement(obj, buttonName, iden) {
    if(buttonName === "Back" || buttonName === "Logout"){
        return{
            login: true,
        }
    }

    if(buttonName === "Register"){
        return{
            register: true,
        }
    }

    if(buttonName === "My orders") {
        return{
            myOrders: true,
        }
    }

    if(buttonName === "Details"){
        console.log(iden);
        console.log(obj);
        for(let i=0; i<obj.products.length; i++){
            if(obj.products[i].id === iden){
                console.log(obj.products[i]);
                return{
                    showing: obj.products[i],
                    details: true,
                }
            }
        }

    }
    return {};
}