async function postData(url = "", data = {}) {
    const response = await fetch(url, {
        method: "POST",
        mode: "cors",
        cache: "no-cache",
        credentials: "same-origin",
        headers: {
            "Content-Type": "application/json",
        },
        redirect: "follow",
        referrerPolicy: "no-referrer",
        body: JSON.stringify(data),
    });
    return response.json();
}

function clearMessages() {
    const chat = document.getElementById("chats");
    chat.innerHTML = "";
}

function addMessage(message) {
    const messageText = message.text;
    const messageUserId = message.user.id;
    const chat = document.getElementById("chats");
    const message1 = document.createElement("div");
    const textNode = document.createTextNode(messageText);
    const clazz = messageUserId === getUserId() ? 'my-chat' : 'client-chat';
    message1.classList.add(clazz);
    message1.appendChild(textNode);
    chat.appendChild(message1);
}

function updateMessages() {
    fetch("/api/v1/messages")
        .then((response) => response.json())
        .then(renderMessages);
}

const renderMessages = (messages) => {
    clearMessages();
    messages.forEach(addMessage);
    let objDiv = document.getElementById("chats");
    objDiv.scrollTop = objDiv.scrollHeight;
};

async function postMessage(messageText) {
    const postMessageDto = {
        userId: getUserId(),
        text: messageText,
    };

    const messages = await postData("/api/v1/messages", postMessageDto);
    console.log('messages', messages);
    renderMessages(messages);
}

function sendMessage() {
    const input = document.getElementById("messageTextInput");
    const messageText = input.value;
    input.value = "";
    postMessage(messageText);
}

function getUserId() {
    let userId = window.localStorage.getItem('userId');
    if (!userId) {
        userId = crypto.randomUUID();
        window.localStorage.setItem('userId', userId);
    }
    return userId;
}

updateMessages();
setInterval(updateMessages, 10000);
