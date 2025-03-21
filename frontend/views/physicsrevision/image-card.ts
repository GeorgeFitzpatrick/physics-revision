import {customElement, html, LitElement} from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-select';

@customElement('image-card')
export class ImageCard extends LitElement {

    createRenderRoot() {
        return this;
    }

    render() {
        return html`
            <li class="bg-contrast-5 flex flex-col items-start p-m rounded-l" id="root">
                <div class="bg-contrast flex items-center justify-center mb-m overflow-hidden rounded-m w-full"
                     style="height: 160px;">
                    <img id="image" class="w-full"/>
                </div>
                <span class="text-xl font-semibold" id="header"></span>
                <span class="text-s text-secondary" id="subtitle"></span>
                <p class="my-m" id="text"></p>
                <vaadin-horizontal-layout>
                    <span theme="badge success" id="year-badge"></span>
                    <span style="margin-left: var(--lumo-space-xs);" theme="badge" id="module-badge"></span>
                </vaadin-horizontal-layout>
            </li> `;
    }

}
