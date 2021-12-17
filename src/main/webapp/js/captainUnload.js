function addProduct() {
    const divMain = document.getElementById('dynamic-div');

    const divEnters = document.createElement('div');
    divEnters.setAttribute('class', 'enters');

    const divTitles = document.createElement('div');
    divTitles.setAttribute('class', 'entersTitles');
    const fh4 = document.createElement('h4');
    fh4.setAttribute('class', 'title');
    fh4.append('Title:');
    const sh4 = document.createElement('h4');
    sh4.setAttribute('class', 'title');
    sh4.append('Number:');
    
    divTitles.appendChild(fh4);
    divTitles.appendChild(sh4);
    divEnters.appendChild(divTitles);

    const divFields = document.createElement('div');
    divFields.setAttribute('class', 'entersFields');
    const finput = document.createElement('input');
    finput.setAttribute('class', 'enter');
    //finput.setAttribute('required');
    finput.setAttribute('name', 'title');
    finput.setAttribute('type', 'text');
    finput.setAttribute('placeholder', 'Enter title');
    const sinput = document.createElement('input');
    sinput.setAttribute('class', 'enter');
    //sinput.setAttribute('required');
    sinput.setAttribute('name', 'number');
    sinput.setAttribute('type', 'number');
    sinput.setAttribute('placeholder', 'Enter number');

    divFields.appendChild(finput);
    divFields.appendChild(sinput);
    divEnters.appendChild(divFields);

    divMain.appendChild(divEnters);
}

function handleUnloadClick() {
    const products = []

    const divMain = document.getElementById('dynamic-div');
    const children = divMain.children;
    for (let i = 0; i < children.length; i++) {
        const title = children[i].lastElementChild.firstElementChild.value;
        const number = children[i].lastElementChild.lastElementChild.value;

        products.push({
            'title': title,
            'number': number
        });
    }

    document.getElementById('input-products').setAttribute('value', JSON.stringify(products));
}