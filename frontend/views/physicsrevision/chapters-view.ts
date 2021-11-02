import {customElement, html, LitElement} from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-select';
// @ts-ignore
import {applyTheme} from '../../generated/theme';

@customElement('chapters-view')
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
                <ol class="gap-m grid list-none m-0 p-0">
                    <slot></slot>
                </ol>
            </main>
        `;
    }

}
