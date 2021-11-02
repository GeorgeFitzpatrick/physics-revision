import {customElement, html, LitElement} from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
// @ts-ignore
import {applyTheme} from '../../generated/theme';

@customElement('chapter-view')
export class ChaptersView extends LitElement {

    connectedCallback() {
        super.connectedCallback();
        applyTheme(this.renderRoot);
    }

    render() {
        return html`
            <main class="max-w-screen-lg mx-auto pb-l px-l">
                <vaadin-horizontal-layout class="items-center justify-between">
                    <vaadin-vertical-layout>
                        <h2 class="mb-0 mt-xl text-3xl" id="title"></h2>
                        <p class="mb-xl mt-0 text-secondary" id="subtitle"></p>
                    </vaadin-vertical-layout>
                </vaadin-horizontal-layout>
                <vaadin-horizontal-layout style="width: 100%; height: 100%; margin: 0; padding: 0;" id="layout">
                </vaadin-horizontal-layout>
            </main>
        `;
    }

}
