function handleLoadClick() {
    const products = [];

    const table = document.getElementById('products-table');

    const children = table.children;
    for (let i = 0; i < children.length; i++) {
        const entersFields = children[i].getElementsByClassName('entersFields')[0].children;
        const number = entersFields[2].value;
        const title = entersFields[3].value;
        if (number != null && number > 0) {
            products.push({
                'title': title,
                'number': number
            });
        }
    }
    if(products.length > 0){
        document.getElementById('input-products').setAttribute('value', JSON.stringify(products));
    }
}