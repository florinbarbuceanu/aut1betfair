const { expect } = require('@wdio/globals')
const LoginPage = require('../pageobjects/login.page')

describe('Test Login application', () => {
    it('User should be able to sign in with valid credentials', async () => {
        await LoginPage.signUp('testing123@test.com', 'SuperSecretPassword!')
        await expect(LoginPage.popupSignupSuccessMessage).toBeExisting()
        await expect(LoginPage.popupSignupSuccessMessage).toHaveText('You successfully signed up!')
    })
})
