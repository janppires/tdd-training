package com.janppires.tdd.garbagenotifier;

public class Email {

    private String recipient;
    private String subject;
    private String body;

    public Email(String recipient, String subject, String body){
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (recipient != null ? !recipient.equals(email.recipient) : email.recipient != null) return false;
        if (subject != null ? !subject.equals(email.subject) : email.subject != null) return false;
        return body != null ? body.equals(email.body) : email.body == null;
    }

    @Override
    public int hashCode() {
        int result = recipient != null ? recipient.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
