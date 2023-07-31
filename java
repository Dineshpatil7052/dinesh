

function loop() {
    var x = document.getElementById("text").value;
    var number = document.getElementById("number").value;
    if (x == "" || number == ("")) {
        alert("No Found ! ")



        return reset;

    }

    for (let i = 0; i < number; i++) {
        document.getElementById("out").innerHTML += x + "  ";

    }
}

function reset() {
    document.getElementById("text").value = "";
    document.getElementById("out").innerHTML = "";
}

function copyToClipboard() {
    var number = document.getElementById("number").value;
    var x = document.getElementById("text").value;

    if (x == "" || number == ("")) {
        alert(" Not Text");
        var copy = document.getElementById("text").style.borderBlockColor = ('red');
        var copy = document.getElementById("number").style.borderBlockColor = ('red');


        return reset();

    }
    setTimeout(function () {
        document.getElementById('copyButton').innerText = "Copy";
    }, 1000);
    const content = document.getElementById('out').innerText;


    // Create a temporary textarea element to hold the content
    const tempTextarea = document.createElement('textarea');
    tempTextarea.value = content;
    document.body.appendChild(tempTextarea);

    // Select the content inside the textarea
    tempTextarea.select();
    tempTextarea.setSelectionRange(0, 99999); // For mobile devices

    // Copy the selected content to the clipboard
    document.execCommand('copy');

    // Remove the temporary textarea from the DOM
    document.body.removeChild(tempTextarea);
    try {
        // Execute the copy command
        document.execCommand('copy');
        document.getElementById('copyButton').innerText = "Copied!";

    } catch (err) {
        console.error('Failed to copy: ', err);
    }


    // Show a message to indicate that the content is copied (optional)
}

document.getElementById('copyButton').addEventListener('click', copyToClipboard);

document.addEventListener('keydown', function (event) {
    if ((event.key === 'c' || event.key === 'C') && (event.ctrlKey || event.metaKey)) {
        event.preventDefault();
        copyToClipboard();
    }
});
