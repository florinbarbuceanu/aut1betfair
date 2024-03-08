const allureReporter = require('@wdio/allure-reporter').default

const { $ } = require('@wdio/globals')

const Page = require('./page');


class LoginPage extends Page {
    get btnSignUpContainer () {
        return $('//*[@content-desc="button-sign-up-container"]');
    }

    get inputEmail () {
        return $('~input-email');
    }

    get inputPassword () {
        return $('~input-password');
    }

    get inputRepeatPassword () {
        return $('~input-repeat-password');
    }

    get btnSignUp () {
        return $('//*[@content-desc="button-SIGN UP"]');
    }

    get popupSignupSuccessMessage() {
        return $('//*[@resource-id="android:id/message"]');
    }

    async signUp (email, password) {
        allureReporter.addStep("Click on login Widget");
        await super.loginWidget.click();
        allureReporter.addStep("Click on Sign Up Button");
        await this.btnSignUpContainer.click();
        allureReporter.addStep("Enter email:"+email);
        await this.inputEmail.setValue(email);
        allureReporter.addStep("Enter password:"+password);
        await this.inputPassword.setValue(password);
        allureReporter.addStep("Repeat password");
        await this.inputRepeatPassword.setValue(password);
        await $("android=new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1,5)");
        await browser.pause(1000);
        allureReporter.addStep("Click on SignUp button");
        await this.btnSignUp.click();
    }
}

module.exports = new LoginPage();